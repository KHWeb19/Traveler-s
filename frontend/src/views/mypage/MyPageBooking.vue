<template>
  <v-container style="text-align: center">
    <div style="display: inline-block">
      <v-row>
        <v-col>
          <my-page-left-menu :userInfo="user"></my-page-left-menu>
        </v-col>
        <v-col>
          <my-page-booking-list
            :bookingLists="bookingLists"
          ></my-page-booking-list>
        </v-col>
      </v-row>
    </div>
  </v-container>
</template>

<script>
import MyPageLeftMenu from "@/components/mypage/MyPageLeftMenu.vue";
import MyPageBookingList from "@/components/mypage/MyPageBookingList.vue";
import { mapActions, mapState } from "vuex";

export default {
  name: "MyBookingList",
  components: {
    MyPageLeftMenu,
    MyPageBookingList,
  },

  computed: {
    ...mapState(["user", "bookingLists"]),
  },
  methods: {
    ...mapActions(["setUser", "fetchBookingLists"]),
  },
  mounted() {
    this.setUser();
    this.fetchBookingLists();
  },
};
</script>

<style></style>
