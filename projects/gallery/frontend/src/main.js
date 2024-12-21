import {createApp} from 'vue';
import {createPinia} from 'pinia';
import App from './App.vue';
import router from './router';

const app = createApp(App);

app.use(createPinia());
app.use(router);

// 마운트 시점 변경(라우터의 초기 탐색 후)
router.isReady().then(() => {
    app.mount('#app');
});