<script setup>
import {getItems} from "@/services/itemService";

// 커스텀 생성 훅
(async function onCreated() {
  const res = await getItems();

  if (res.status === 200) {
    console.log(res.data);
  }
})();
</script>