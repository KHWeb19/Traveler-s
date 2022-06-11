<template>
    <div class="row">
        <div class="col-sm-3 col-xs-3 col-md-3">
            <v-card class="mx-auto" max-width="120">
                <v-list rounded>
                    <v-subheader>숙박 인원</v-subheader>
                    <v-list-item-group v-model="selectedPeopleNum" color="primary">
                        <v-list-item v-for="(Num, i) in Num" :key="i">
                            <v-list-item-content>
                                <v-list-item-title v-text="Num.text"></v-list-item-title>
                            </v-list-item-content>
                        </v-list-item>
                    </v-list-item-group>
                </v-list>
            </v-card>
        </div>
    </div>
</template>

<script>


  export default {

    component: {
        
    },

    data: () => ({
      selectedPeopleNum: 1,
      Num: [
        { text: '1'},
        { text: '2'},
        { text: '3'},
      ]
    }),
  }
</script>

<style scoped>

.v-subheader {
    font-size: 13px;
}

.v-list-item-content {
    font-size: 13px;
}


</style>