<script setup lang="ts">
import BookItem from '../components/BookItem.vue';
import type { Book } from '../shared/interfaces';
import { useBooks } from '../shared/stores/bookStore';

const bookStore = useBooks();
bookStore.fetchBooks();

</script>

<template>
    <div class="mx-8">
        <div class="grid grid-cols-4 grid-flow-row w-full gap-8">
            <BookItem v-for="book in bookStore.filteredBooks" :book="book" :key="book.title" />
        </div>
    </div>
</template>