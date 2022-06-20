<template>
  <div>
    <h4>MY 페이지</h4>
    <br /><br />
    <div class="left_menu">
      <v-col>
        <v-row>
          <v-col>
            <v-row>
              <v-layout>
                <img
                  v-if="userInfo.profile_path"
                  :src="require(`@/assets/img/${this.userInfo.profile_path}`)"
                  id="imageBefore"
                  class="proimg"
                />
                <img
                  v-else
                  src="@/assets/img/profile.png"
                  id="imageBefore"
                  class="proimg"
                />
              </v-layout>
            </v-row>
          </v-col>
          <div></div>
          <ul>
            <p>{{ userInfo.name }}</p>
            <br />
            <br />
            <br />
            <br />
            <br />

            <br />

            <li>
              <router-link :to="{ name: '', params: {} }">
                <strong style="text-align: center"> 위시리스트 </strong>
              </router-link>
            </li>
            <br />
            <br />
            <br />
            <li>
              <router-link :to="{ name: '', params: {} }">
                <strong style="text-align: center"> 예약 내역 확인 </strong>
              </router-link>
            </li>
            <br />
            <br />
            <br />
            <li>
              <router-link :to="{ name: '', params: {} }">
                <strong style="text-align: center" @click="management">
                  숙소 관리
                </strong>
              </router-link>
            </li>
          </ul>
        </v-row>
      </v-col>
    </div>
  </div>
</template>

<script>
export default {
  props: ["userInfo"],
  methods: {
    management() {
      alert("권한이 없습니다.");
    },
  },
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
  height: 150px;
  text-align: center;
  margin-left: auto;
  margin-right: auto;
  border-radius: 70%;
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
