<template>
<div>
<h1 style="margin-top: 150px;margin-left: 200px">欢迎登录高校学生宿舍管理系统</h1><br/>
  <h2 style="margin-left: 240px">---您当前的身份是{{roleName}}</h2>

</div>
</template>

<script>
export default {

  name: "Home",
  data(){
    return{
      roleName: '1',
    }
  },
  created() {
    this.roleName= JSON.parse(sessionStorage.getItem("user")).role[0].roleName;
  }

}
</script>

<style scoped>

</style>