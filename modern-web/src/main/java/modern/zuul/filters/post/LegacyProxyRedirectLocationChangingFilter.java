package modern.zuul.filters.post;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class LegacyProxyRedirectLocationChangingFilter extends ZuulFilter {

    private List<String> hosts;

    public LegacyProxyRedirectLocationChangingFilter(@Value("${service-legacy.ribbon.listOfServers:}") List<String> hosts) {
        log.info("변경 호스트 목록: {} ", hosts);

        if (CollectionUtils.isEmpty(hosts)) {
            this.hosts = Collections.emptyList();
        } else {
            this.hosts = hosts.stream()
                              .map(host -> host.replace(":443", ""))
                              .collect(Collectors.toList());
        }
    }

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 100;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext.getCurrentContext()
                      .getZuulResponseHeaders()
                      .stream()
                      .filter(header -> HttpHeaders.LOCATION.equalsIgnoreCase(header.first()))
                      .filter(header -> ResourceUtils.isUrl(header.second()))
                      .filter(header -> hosts.stream().anyMatch(host -> header.second().contains(host)))
                      .findAny()
                      .ifPresent(header -> {
                          val uri = UriComponentsBuilder.fromHttpUrl(header.second()).build();
                          log.debug("Location 헤더를 '{}'에서 '{}'로 변경합니다.", header.second(), uri.getPath());
                          header.setSecond(uri.getPath());
                      });

        return null;
    }

}
