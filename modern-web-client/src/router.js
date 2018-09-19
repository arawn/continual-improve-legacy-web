import Vue from 'vue'
import Router from 'vue-router'
import Order from '@/components/order/Order.vue'

Vue.use(Router)

export default new Router({
    mode: 'history',
    routes: [{
        path: '/order.jsp',
        component: Order
    }]
})