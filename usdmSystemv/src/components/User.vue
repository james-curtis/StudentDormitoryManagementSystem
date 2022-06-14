<template>
  <div>
    <div id="select_id">
      <el-input v-model="search" placeholder="请输入内容" prefix-icon="el-icon-search"></el-input>
      <el-button type="primary" style="margin-left: 10px" @click="locad"> 搜索</el-button>
    </div>
    <!--    按钮区-->
    <div style="margin-left: 10px ;">
<!--      <el-button type="primary" @click="dialogVisible= true">新增</el-button>-->
      <el-button  type="primary" @click="dialogVisible= true">新增</el-button>
    </div>
    <div style="margin: 10px">
      <el-table :data="tableData" border style="width: 100%">
        <el-table-column prop="num" label="编号" width="150"></el-table-column>
        <el-table-column prop="name" label="姓名" width="180"></el-table-column>
        <el-table-column prop="username" label="用户名" width="170"></el-table-column>
        <el-table-column prop="password" label="密码" width="170">
        </el-table-column>
        <el-table-column prop="telephone" label="联系电话" width="180"></el-table-column>

        <el-table-column align="left" label="操作" width="160">
          <template #default="scope">
            <el-button size="mini"  type="primary"  @click="handleEdit(scope.row)">修改</el-button>
<!--            <el-button size="mini" type="primary" @click="handleEdit(scope.row)">修改</el-button>-->
            <el-popconfirm title="确定删除吗？" @confirm="handleDelete(scope.row)">
              <template #reference>
                <el-button style="margin-left: 10px" size="mini" type="danger">删除</el-button>
              </template>
            </el-popconfirm>
          </template>
        </el-table-column>
      </el-table>

      <el-dialog title="弹窗" :visible.sync="dialogVisible" width="30%" :before-close="handleClose">
        <el-form ref="form" v-model="from" label-width="80px">
          <el-form-item label="编号">
            <el-input v-model="from.num"></el-input>
          </el-form-item>

          <el-form-item label="姓名">
            <el-input v-model="from.name"></el-input>
          </el-form-item>

          <el-form-item label="用户名">
            <el-input v-model="from.username"></el-input>
          </el-form-item>
          <el-form-item label="密码">
            <el-input v-model="from.password"></el-input>
          </el-form-item>
          <el-form-item label="联系方式">
            <el-input v-model="from.telephone"></el-input>
          </el-form-item>

        </el-form>
        <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="save(); dialogVisible = false">确 定</el-button>
  </span>
      </el-dialog>

    </div>
  </div>

</template>

<script>


import request from "@/until";

export default {
  name: "User",
  data() {
    return {
      from: {
        id: '',
        num: '',
        name: '',
        username: '',
        password: '',
        telephone: '',
      },
      tableData: [],
      dialogVisible: false,
      search: '',
    }
  },
  created() {

    this.locad();
  },

  methods: {
    save() {
      if (this.from.id) {//更新
        console.log("更新")
        request.put("/api/user/update", this.from).then(res => {
          if (res.code === "0") {
            this.$message({
              type: "success",
              message: "更新成功"
            })

            this.locad();
          } else {
            this.$message({
              type: "error",
              message: "更新失败"
            })
          }
        })
      } else {// 添加
        console.log(this.from.telephone);
        request.post("/api/user/save", this.from).then(res => {
          console.log(res)
          if (res.code === "0") {
            this.$message({
              type: "success",
              message: "添加成功"
            })
            this.from = [],
                this.locad();
          } else {
            this.$message({
              type: "error",
              message: "添加失败"
            })
          }
        })
      }
    },

    locad() {
      request.get("/api/user/search", {
        params: {
          search: this.search,
        }
      }).then(res => {
        console.log(res.data)
        this.tableData = res.data
      })
    },


    handleEdit(row) {
      this.from = JSON.parse(JSON.stringify(row))
      // console.log("用户")
      // console.log(JSON.parse(JSON.stringify(row)))
      // console.log("___________________________________")
      // console.log(this.from)
      this.dialogVisible = true;

    },

    handleDelete(row) {
      console.log(row.id)
      request.delete("/api/user/delete/" + row.id).then(res => {
        if (res.code === "0") {
          this.$message({
            type: "success",
            message: "删除成功"
          })
          this.locad();
        } else {
          this.$message({
            type: "error",
            message: "删除失败"
          })
        }
      })
    },

    handleClose(done) {
      done();
      this.dialogVisible = false
    }


  }
}
</script>

<style scoped>

#select_id {
  display: flex;
  margin: 10px;
  width: 300px;
}
</style>
