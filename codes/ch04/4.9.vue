<script setup>
const props = defineProps({ // ①
  color: String
});
</script>

<template>
  <div :style="{color: props.color}">{{ props.color || 'BLACK' }} TIRE</div> <!-- ② -->
</template>