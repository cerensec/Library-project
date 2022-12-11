<script setup lang="ts">
import { router } from '../router';

function login() {
    router.push('/search');
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
            placeholder="Nom d'utilisateur"
        />
        <input
            class="rounded-lg outline outline-2 outline-gray-200 mb-5 focus:outline-blue-600"
            type="password"
            placeholder="Mot de passe"
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
