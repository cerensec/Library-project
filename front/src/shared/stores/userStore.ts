import { defineStore } from 'pinia';
import { User } from '../interfaces/user.interface';
import { login } from '../services';

interface UserState {
    user: User | null;
}

export const useUser = defineStore('user', {
    state: (): UserState => ({
        user: null,
    }),

    getters: {
        isAdmin(state): boolean {
            return state.user?.role === 'admin';
        },
    },

    actions: {
        async login(username: string, password: string) {
            try {
                this.user = await login(username, password);
                console.log('user: ', this.user);
            } catch (e) {
                throw e;
            }
        },
    },
});
