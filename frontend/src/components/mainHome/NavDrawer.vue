<template>
  <div>
    <v-list-item>
      <v-list-item-content>
        <v-list-item-title class="title">
          타이틀
        </v-list-item-title>
        <v-list-item-subtitle>
          서브타이틀
        </v-list-item-subtitle>
      </v-list-item-content>
    </v-list-item>
    <v-divider></v-divider>
    <v-list>
      <v-list-group
        v-for="(item, i) in items"
        :key="i"
        v-model="item.active"
        no-action>

        <template v-slot:activator>
          <v-list-item-content>
            <v-list-item-title v-text="item.title"></v-list-item-title>
          </v-list-item-content>
        </template>
        
        <v-list-item
          v-for="subItem in item.subItems"
          :key="subItem.title"
          :to="subItem.to">
          <v-list-item-content>
            <v-list-item-title v-text="subItem.title"></v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list-group>
    </v-list>
  </div>
</template>

<script>

export default {
    name: "NavDrawer",

    data() {
        return {
            items: [
                { title: '회원 메뉴', active: true, subItems: [
                { title: '마이페이지', to: '/mypage' },
                { title: '위시리스트', to: '' },
                { title: '예약 내역 확인', to: '' },
                ]},
                { title: '관리자 메뉴', subItems: [
                        { title: '관리자 메뉴얼', to: '' },
                        { title: '예약관리', to: '' },
                        { title: '객실등록', to: '/roomRegister' },
                        { title: '객실설정', to: '' },
                        { title: '요금설정', to: '' },
                        { title: '호텔등록', to: '/BHotelRegisterPage'},
                        { title: '숙박관리', to: '' },
                        { title: '숙소관리', to: '/BHotelListPage' },
                        { title: '객실관리', to: '' },
                    ]
                }
            ]
        }
    }
}

</script>

<style lang="">

</style>
