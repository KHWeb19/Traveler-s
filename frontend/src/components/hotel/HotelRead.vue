<template>
    <div>
        <table>
            <tr>
                <td>게시물 번호</td>
                <td>
                    <input type="text" :value="hotel.hotelNo" readonly/>
                </td>
            </tr>
            <tr>
                <td>제목</td>
                <td>
                    <input type="text" :value="hotel.hotelName" readonly/>
                </td>
            </tr>
            <tr>
                <td>작성자</td>
                <td>
                    
                </td>
            </tr>
            <tr>
                <td>등록일자</td>
                <td>
                    <input type="text" :value="hotel.regDate" readonly/>
                </td>
            </tr>
            <tr>
                <td>본문</td>
                <td>
                    <textarea cols="50" rows="20" :value="hotel.hotelInfo" readonly>
                    </textarea>
                </td>
            </tr>
        </table>
    </div>
</template>

<script>
export default {
    name: 'HotelRead',
    props: {
        hotel: {
            type: Object,
            require: true
        }
    }
}
</script>

<style>

</style>