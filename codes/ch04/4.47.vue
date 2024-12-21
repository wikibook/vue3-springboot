<script setup>
import {onMounted, onUnmounted} from "vue";

onMounted(() => {
  console.log("onMounted", document.getElementById("greeting"));
});

onUnmounted(() => {
  console.log("onUnmounted", document.getElementById("greeting"));
});
</script>

<template>
  <div id="greeting">Aloha!</div>
</template>