import { defineStore } from 'pinia';
import { User } from '../interfaces/user.interface';
import { login } from '../services';

interface UserState {
    user: User | null;
    connected: boolean;
}

export const useUser = defineStore('user', {
    state: (): UserState => ({
        user: null,
        connected: false,
    }),

    getters: {
        isAdmin(state): boolean {
            return state.user?.role === 'admin';
        },
    },

    actions: {
        async login(username: string, password: string) {
            try {
                const user = await login(username, password);
                if (user) {
                    this.user = user;
                    this.connected = true;
                }
            } catch (e) {
                throw e;
            }
        },

        logout() {
            this.user = null;
            this.connected = false;
        },
    },
});
