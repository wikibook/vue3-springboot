<script setup>
const fruits = ["apple", "banana", "pear"];
</script>

<template>
  <div v-for="f in fruits">{{ f }}</div>
</template>