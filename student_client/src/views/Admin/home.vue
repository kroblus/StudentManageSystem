<template>
  <div>
    <el-container>
      <el-main>
        <h1>admin home</h1>
        <el-card style="width: 40%">
          <p><i class="el-icon-s-home" style="margin-right: 18px"></i>项目名：学生选课系统</p>
          <p><i class="el-icon-s-custom" style="margin-right: 18px"></i>开发人员：kroblus</p>
          <p><i class="el-icon-location-outline" style="margin-right: 18px"></i>带专</p>
          <p><i class="el-icon-chat-round" style="margin-right: 18px"></i>QQ: 1656227304</p>
        </el-card>
        <logout></logout>
      </el-main>
    </el-container>
  </div>
</template>

<script>
import Logout from "@/components/logout";

export default {
  name: "home",
  components: {Logout},
}
</script>

<style scoped>

</style>