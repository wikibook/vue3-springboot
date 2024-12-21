import {createRouter, createWebHistory} from 'vue-router';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: () => import('../views/Home.vue')
    },
    {
      path: '/join',
      name: 'join',
      component: () => import('../views/Join.vue')
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('../views/Login.vue')
    },
    {
      path: '/cart',
      name: 'cart',
      component: () => import('../views/Cart.vue')
    },
    {
      path: '/order',
      name: 'orderForm',
      component: () => import('../views/OrderForm.vue')
    },
    {
      path: '/orders',
      name: 'orders',
      component: () => import('../views/Orders.vue')
    },
    {
      path: '/orders/:id',
      name: 'orderDetail',
      component: () => import('../views/OrderDetail.vue')
    },
  ]
});

export default router;