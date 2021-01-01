// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import 'element-ui/lib/theme-chalk/index.css'
import element from './element/element.js'
import axios from 'axios'
import qs from 'qs'
import './assets/css/all.css'
/*设置跨域访问的基地址*/
axios.defaults.baseURL = 'http://localhost:8080';
/*默认发送cookie*/
axios.defaults.withCredentials=true;
Vue.use(element);
Vue.prototype.$axios = axios/*这里不能删*/
Vue.prototype.$qs = qs;
Vue.config.productionTip = false;


import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

Vue.use(ElementUI);




new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>',

})
