<template>
  <v-col>
    <v-col v-for="(index, i) in userInfo.roles" :key="i">
      <v-list v-if="index.name == 'ROLE_CEO'">
        <v-list-group
          v-for="(item, n) in items"
          :key="n"
          v-model="item.active"
          no-action
        >
          <template v-slot:activator>
            <v-list-item-content>
              <v-list-item-title v-text="item.title"></v-list-item-title>
            </v-list-item-content>
          </template>
          <v-list-item
            v-for="subItem in item.subItems"
            :key="subItem.title"
            :to="subItem.to"
          >
            <v-list-item-content>
              <v-list-item-title v-text="subItem.title"></v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list-group>
      </v-list>

      <v-list v-else>
        <v-list-group
          v-for="(item2, n) in items2"
          :key="n"
          v-model="item2.active"
          no-action
        >
          <template v-slot:activator>
            <v-list-item-content>
              <v-list-item-title v-text="item2.title"></v-list-item-title>
            </v-list-item-content>
          </template>
          <v-list-item
            v-for="subItem2 in item2.subItems2"
            :key="subItem2.title"
            :to="subItem2.to"
          >
            <v-list-item-content>
              <v-list-item-title v-text="subItem2.title"></v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list-group>
      </v-list>
    </v-col>
  </v-col>
</template>

<script>
export default {
  name: "NavDrawer",

  props: {
    userInfo: [],
  },

  data() {
    return {
      items: [
        {
          title: "회원 메뉴",
          active: true,
          subItems: [
            { title: "마이페이지", to: "/mypage" },
            { title: "위시리스트", to: "" },
            { title: "예약 내역 확인", to: "" },
          ],
        },
        {
          title: "관리자 메뉴",
          subItems: [
            { title: "관리자 메뉴얼", to: "" },
            { title: "예약관리", to: "" },
            { title: "호텔등록", to: "/BHotelRegisterPage" },
            { title: "숙소관리", to: "/BHotelListPage" },
            { title: "객실관리", to: "" },
          ],
        },
      ],
      items2: [
        {
          title: "회원 메뉴",
          active: true,
          subItems2: [
            { title: "마이페이지", to: "/mypage" },
            { title: "위시리스트", to: "" },
            { title: "예약 내역 확인", to: "" },
          ],
        },
      ],
    };
  },
};
</script>

<style scoped></style>
