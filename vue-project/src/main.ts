import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'
import piniaPluginPersistedstate from 'pinia-plugin-persistedstate'
import axios from 'axios'
import { useUsuarioStore } from './stores/usuario'

axios.defaults.baseURL = 'http://localhost:8080'

const app = createApp(App)
const pinia  = createPinia()
pinia.use(piniaPluginPersistedstate)
app.use(pinia)
app.use(router)

// MANDA O TOKEN AUTOMATICO
axios.interceptors.request.use(config => {
    const store = useUsuarioStore();
    if(store.token){
        config.headers.Authorization = store.token;
    }
    return config;
})

app.mount('#app')
