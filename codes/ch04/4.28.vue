<script setup>
const fruits = ["apple", "banana", "pear"];
</script>

<template>
  <template v-for="f in fruits">{{ f }}</template>
</template>