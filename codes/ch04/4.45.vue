<script setup>
import {onMounted} from "vue";

onMounted(() => {
  console.log(document.getElementById("message"));
});
</script>

<template>
  <div id="message">Aloha!</div>
</template>