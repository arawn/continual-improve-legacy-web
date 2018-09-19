import 'bootstrap/dist/js/bootstrap.js'
import 'bootstrap/dist/css/bootstrap.css'
import './assets/css/cover.css'

import Vue from 'vue'
import axios from 'axios'
import router from './router.js'
import App from './App.vue'

Vue.config.productionTip = false
Vue.prototype.$http = axios

new Vue({
    render: h => h(App), router
}).$mount('#app')