<script setup lang="ts">
import { useRoute } from 'vue-router';
import { useBooks } from '../shared/stores/bookStore';

const bookStore = useBooks();
const route = useRoute();
const bookId = parseInt(route.params.id as string);

const book = bookStore.getBook(bookId);

</script>

<template>
    <div class="card text-center w-1/3 m-auto flex flex-col">
        <img class="w-3/5 mb-3 m-auto" src="https://m.media-amazon.com/images/I/81A480IJsjL._AC_UL640_QL65_.jpg" alt="">
        <h1>{{ book?.title }}</h1>
        <h2>{{ book?.author }}</h2>
        <p>{{ book?.resume }}</p>
        <small>{{ book?.language }}</small>
        <small>{{ book?.numberOfPages }} pages</small>
        <small>{{ book?.format }}</small>
    </div>
</template>