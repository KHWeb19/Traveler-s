<template>
  <v-container style="padding: 0px; margin-top: 20px">
    <v-card class="right">
      <div style="display: flex; justify-content: center">
        <v-form ref="form" lazy-validation> </v-form>
        <table border="1">
          <tr class="tb1">
            <th align="center" width="100">번호</th>
            <th align="center" width="150">호텔 이름</th>
            <th align="center" width="640">호텔 주소</th>
          </tr>
          <tr
            v-if="
              !jpaBoards || (Array.isArray(jpaBoards) && jpaBoards.length === 0)
            "
          >
            <td colspan="4">현재 등록된 게시물이 없습니다!</td>
          </tr>
          <tr v-else v-for="board in jpaBoards" :key="board.boardNo">
            <td align="center">
              {{ board.boardNo }}
            </td>
            <td align="left">
              <router-link
                :to="{
                  name: 'JpaBoardReadPage',
                  params: { boardNo: board.boardNo.toString() },
                }"
              >
                {{ board.title }}
              </router-link>
            </td>
            <td align="right">
              {{ board.writer }}
            </td>
            <td align="center">
              {{ board.regDate }}
            </td>
          </tr>
        </table>
      </div>
    </v-card>
  </v-container>
</template>

<script>
export default {
  name: "MyPageWish",
};
</script>

<style scoped>
.left_menu {
  width: 200px;
  height: 848px;
  border-right-width: 3px;
  border-right-color: rgba(64, 64, 64);
  border-right-style: dotted;
  padding: 3%;
  background: rgba(64, 64, 64);
  color: white;
}
.proimg {
  width: 150px;
}

.col1 {
  background: rgb(224, 224, 224);
}
.btn2 {
  background: rgb(224, 224, 224);
}

.right {
  width: 600px;
  height: 848px;
  background: rgb(250, 250, 250);
}
.tb1 {
  background: #ffe082;
}

ul a {
  color: inherit;
}

ul {
  list-style: none;
  margin: 20% 0 0 0;
}

a {
  text-decoration: none;
}
</style>
