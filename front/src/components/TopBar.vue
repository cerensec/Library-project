<script setup lang="ts">
import { computed } from 'vue';
import { useRoute } from 'vue-router';
import { useBooks } from '../shared/stores/bookStore';
import { useUser } from '../shared/stores';

const currentRoute = computed(() => {
    return useRoute().name;
});

const bookStore = useBooks();
const userStore = useUser();
</script>

<template>
    <nav class="bg-white shadow-lg mb-10">
        <div class="flex w-full">
            <div class="flex grow">
                <a href="#" class="flex items-center py-4 px-2">
                    <span class="font-bold text-slate-800 text-3xl">
                        <a href="/search">Library</a>
                    </span>
                </a>
            </div>
            <div v-if="currentRoute !== 'login'" class="flex">
                <div
                    v-if="userStore.isAdmin"
                    class="hidden md:flex items-center space-x-1"
                >
                    <router-link class="mr-3 text-xl" to="/search">
                        Search
                    </router-link>
                    <router-link class="text-xl" to="/manage">
                        Manage
                    </router-link>
                </div>
                <div
                    class="rounded-lg outline outline-2 outline-gray-200 m-5 focus-within:outline-blue-600"
                >
                    <input
                        @input="
                            bookStore.search =
                                //@ts-ignore
                                ($event.target as HTMLElement).value
                        "
                        class="outline-none p-2"
                        type="text"
                        placeholder="Search a book"
                    />
                    <i class="fa-solid fa-magnifying-glass mr-2"></i>
                </div>
            </div>
        </div>
    </nav>
</template>

<style scoped>
.router-link-active {
    color: theme('colors.blue.600');
}
</style>
