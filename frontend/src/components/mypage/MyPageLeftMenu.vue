<template>
    <div>
      <h4>MY 페이지</h4>
      <br /><br />
      <div class="left_menu">
        <v-col>
          <v-row>
            <ul>
              <div>
                <tr>
                  
                </tr>
              </div>
              <br />
              <br />
              <br />
              <br />
              <br />
              <br />
              <li>
                <router-link :to="{ name: '', params: {  } }">
                  <strong style="text-align: center"> 프로필 </strong>
                </router-link>
              </li>
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
                <router-link
                  :to="{ name: '', params: {  } }"
                >
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