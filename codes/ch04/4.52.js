import {createRouter, createWebHistory} from 'vue-router';
import Join from '../views/Join.vue';

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/join', // 회원가입 URL 경로
            component: Join // 회원가입 컴포넌트
        },
        {
            path: '/login', // 로그인 URL 경로
            component: () => import('../views/Login.vue') // 로그인 컴포넌트
        },
    ]
});

export default router;