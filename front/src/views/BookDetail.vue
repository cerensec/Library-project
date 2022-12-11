<script setup lang="ts">
import { useRoute } from 'vue-router';
import { useBooks } from '../shared/stores/bookStore';

const bookStore = useBooks();
const route = useRoute();
const bookId = route.params.id as string;

const book = bookStore.getBook(bookId);
console.log('front book',book);
</script>

<template>
    <div class="card text-center w-1/3 m-auto flex flex-col">
        <img class="w-3/5 mb-3 m-auto" src="https://m.media-amazon.com/images/I/81A480IJsjL._AC_UL640_QL65_.jpg" alt="">
        <h1>{{ book.title }}</h1>
        <!-- <h2>{{ book?.author }}</h2> -->
        <p>{{ book.overview }}</p>
        <p>{{book.publisher}}</p>
        <p>{{book.publicationDate}}</p>
        <small>{{ book.langue.name }}</small>
        <small>{{ book.numberOfPages }} pages</small>
        <small>{{ book.format.name }}</small>
    </div>
</template>