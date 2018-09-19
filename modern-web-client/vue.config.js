module.exports = {
    outputDir: '../modern-web/src/generated/client-resources',
    assetsDir: 'assets',
    indexPath: 'templates/index.html',
    devServer: {
        proxy: {
            '/api': {
                target: 'http://localhost:9100',
                changeOrigin: true
            }
        }
    }
}