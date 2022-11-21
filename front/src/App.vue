<script setup lang="ts">
import TopBar from './components/TopBar.vue';
import Login from './views/Login.vue';
import BookList from './views/BookList.vue';
import AdminBookList from './views/AdminBookList.vue';
import type { Book } from './shared/interfaces';

</script>

<template>
  <div>
    <TopBar/>
    <router-view />
  </div>
</template>

<style>
</style>