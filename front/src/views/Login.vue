<script setup lang="ts">
import { ref } from 'vue';
import { router } from '../router';
import { useUser } from '../shared/stores/userStore';

const userStore = useUser();

const username = ref('');
const password = ref('');

userStore.user = null;

async function login() {
    try {
        await userStore.login(username.value, password.value);
    } catch (error) {
        console.log(error);
    }
    if (userStore.user) {
        router.push('/search');
    } else {
        alert('Invalid credentials');
    }
}
</script>

<template>
    <div class="card flex flex-col w-1/3 m-auto">
        <h1 class="text-2xl mb-5">
            Login to the <span class="text-blue-600">Library</span>
        </h1>
        <input
            class="rounded-lg outline outline-2 outline-gray-200 mb-5 focus:outline-blue-600"
            type="text"
            v-model="username"
            placeholder="Username"
        />
        <input
            class="rounded-lg outline outline-2 outline-gray-200 mb-5 focus:outline-blue-600"
            type="password"
            v-model="password"
            placeholder="Password"
        />
        <button
            @click="login"
            class="text-xl py-2 text-white rounded-lg bg-blue-600 hover:bg-blue-700"
        >
            Login
        </button>
    </div>
</template>

<style scoped>
input {
    padding: 5px;
}
</style>
