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

// 이 부분(메서드 선언)
const getMvpName = () => {
  if (state.mvpId) {
    const player = state.players.find(p => p.id === state.mvpId);

    if (player) {
      return player.name;
    }
  }

  return "없음";
};
</script>

<template>
  <div>
    <h1>오늘의 MVP</h1>
    <!-- 이 부분(메서드 호출) -->
    <div>{{ getMvpName() }}</div>
  </div>
</template>