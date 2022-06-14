import Vue from 'vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import App from './App.vue'
import router from "@/router";
import './assets/css/global.css'




Vue.config.productionTip = false
Vue.use(ElementUI,{size:'small'}).use(router)
new Vue({
    render: h => h(App),
    router,
}).$mount('#app')
