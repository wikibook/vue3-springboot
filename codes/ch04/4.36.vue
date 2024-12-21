<script setup>
import {reactive} from "vue";

// 반응형 상태
const state = reactive({
  mvpId: 7,
  players: [
    {id: 7, name: "John Doe"},
    {id: 9, name: "Jane Lee"},
    {id: 12, name: "James Park"}
  ]
});
</script>

<template>
  <div>
    <h1>오늘의 MVP</h1>
    <div>
      <template v-if="state.mvpId">
        {{ state.players.find(m => m.id === state.mvpId)?.name || '없음' }}
      </template>
      <template v-else>없음</template>
    </div>
  </div>
</template>