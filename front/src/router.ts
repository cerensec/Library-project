import { createRouter, createWebHistory } from 'vue-router';
import { initialFetchBooks, useUser } from './shared/stores';

export const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            redirect: '/login',
        },
        {
            path: '/login',
            component: () => import('./views/Login.vue'),
            name: 'login',
        },
        {
            path: '/search',
            beforeEnter: [initialFetchBooks, verifyAuth],
            component: () => import('./views/BookList.vue'),
            name: 'search',
        },
        {
            path: '/manage',
            beforeEnter: [verifyAuth, verifyRights],
            component: () => import('./views/AdminBookList.vue'),
            name: 'manage',
        },
        {
            path: '/add',
            beforeEnter: [verifyAuth, verifyRights],
            component: () => import('./views/BookForm.vue'),
            name: 'add',
        },
        {
            path: '/detail/:id',
            component: () => import('./views/BookDetail.vue'),
        },
        {
            path: '/:notfound(.*)*',
            component: () => import('./views/NotFound.vue'),
        },
    ],
});

function verifyAuth() {
    const userStore = useUser();
    if (!userStore.connected) {
        console.log('not connected');
        router.push('/login');
    }
}

function verifyRights() {
    const userStore = useUser();
    if (!userStore.isAdmin) {
        console.log('not admin');
        router.push('/search');
    }
}
