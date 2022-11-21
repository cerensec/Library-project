import { createRouter, createWebHistory } from 'vue-router'

export const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            redirect: '/login'
        },
        {
            path: '/login',
            component: () => import('./views/Login.vue'),
            name: 'login'
        },
        {
            path: '/search',
            component: () => import('./views/BookList.vue'),
            name: 'search'
        },
        {
            path: '/manage',
            component: () => import('./views/AdminBookList.vue'),
            name: 'manage'
        } ,
        {
            path: '/add',
            component: () => import('./views/BookForm.vue'),
            name: 'add'
        },
        {
            path: '/detail/:id',
            component: () => import('./views/BookDetail.vue'),
        }
    ]
})