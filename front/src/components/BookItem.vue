<script setup lang="ts">
import type { Book } from '../shared/interfaces';

defineProps<{
    book: Book;
}>();
</script>

<template>
    <router-link :to="{ path: '/detail/' + book.isbn }">
        <div class="card text-center">
            <img
                class="w-56 mb-3 m-auto"
                src="https://m.media-amazon.com/images/I/81A480IJsjL._AC_UL640_QL65_.jpg"
                alt=""
            />
            <h1 class="text-2xl">{{ book.title }}</h1>
            <p>{{ book.overview }}</p>
            <small>{{ book.author.name }}</small>
        </div>
    </router-link>
</template>

<style scoped>
.card {
    min-width: 0;
}
</style>
