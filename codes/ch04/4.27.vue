<script setup>
const fruits = ["apple", "banana", "pear"];
</script>

<template>
  <div v-for="(f, idx) in fruits">{{ idx }} {{ f }}</div>
</template>