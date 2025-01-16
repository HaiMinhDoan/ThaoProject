<template>
    <div id="preloader">
        <div class="loader"></div>
    </div>
</template>

<script setup>
import { onMounted } from 'vue';
import { preloaderFunc } from '../assets/js/main.js';
onMounted(() => {
    preloaderFunc();
});
</script>
<style lang="">
  </style>