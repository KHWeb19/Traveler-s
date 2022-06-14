<template>
    <v-col>
        <v-row>
            <v-col cols="12" sm="3">
                <v-select :items="items" prepend-icon="mdi-bed" label="인원 선택" rounded solo></v-select>
            </v-col>
            <v-col cols="12" sm="6">
                <v-text-field prepend-icon="mdi-city-variant-outline" label="도시 입력" rounded solo type="city">
                    <template #append>
                        <v-btn type="submit" value="Subscribe">
                            검색하기
                        </v-btn>
                    </template>
                </v-text-field>
            </v-col>
        </v-row>
    </v-col>
</template>

<script>

  export default {

    component: {
        
    },

    data: () => ({
      items: ['1', '2', '3', '4'],
      value: null,
    }),
  }
</script>

<style scoped>
.v-text-field{
    width: 350px;
}
.v-btn {
    color: rgb(55,55,55);
    width: 20px;
    font-size:5px;
}

</style>