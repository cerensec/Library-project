<script setup lang="ts">
import { router } from '../router';
import type { Book } from '../shared/interfaces';
import { useBooks } from '../shared/stores/bookStore';

const bookStore = useBooks();

bookStore.fetchBooks();

if (bookStore.needRefresh) {
    bookStore.fetchBooks();
}
</script>

<template>
    <div class="text-start card w-4/5 m-auto pl-8 mb-5">
        <h1 v-if="false">Loading ...</h1>
        <div v-else class="flex pl-3 mb-5">
            <h1 class="text-2xl mr-8">Books list</h1>
            <router-link to="/add">
                <button
                    class="text-white w-24 py-2 rounded-lg bg-blue-600 hover:bg-blue-700 mr-5"
                >
                    Add
                </button>
            </router-link>
        </div>
        <table class="w-full m-auto">
            <thead>
                <tr>
                    <td class="rounded-l-lg">Title</td>
                    <td>Author</td>
                    <td>Language</td>
                    <td class="w-28"></td>
                    <td class="w-28 rounded-r-lg"></td>
                </tr>
            </thead>
            <tbody>
                <tr
                    v-for="book in bookStore.filteredBooks"
                    :key="book.isbn"
                    class="border-b-2 border-gray-100"
                >
                    <td>{{ book.title }}</td>
                    <td>Author</td>
                    <!-- <td>{{ book.author }}</td> -->
                    <td>{{ book.langue.name }}</td>
                    <td class="">
                        <router-link
                            :to="{ name: 'add', params: { bookId: book.isbn } }"
                        >
                            <button
                                class="text-white mr-3 w-24 py-2 rounded-lg bg-green-500 hover:bg-green-600 items-center"
                            >
                                Edit
                            </button>
                        </router-link>
                    </td>
                    <td class="">
                        <button
                            @click="bookStore.deleteBook(book.isbn)"
                            class="text-white w-24 py-2 rounded-lg bg-red-500 hover:bg-red-600"
                        >
                            Delete
                        </button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<style scoped>
td {
    height: theme('width.20');
}
thead > tr > td {
    background-color: theme('colors.gray.100');
}
tr > td:first-child {
    padding-left: 1rem;
}
</style>
