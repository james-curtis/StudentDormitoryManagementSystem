<template>

  <div>
    <div id="select_id" style="width: 350px ;display: flex;margin-top: 10px;margin-left: 10px">
      <el-input placeholder="请输入内容" prefix-icon="el-icon-search" v-model="dname"></el-input>
      <el-button type="primary" style="margin-left: 10px" @click="searchByName"> 搜索</el-button>
    </div>
    <!--    按钮区-->
    <div style="margin-left: 10px ; margin-top: 10px">
      <el-button type="primary" @click="dialogVisible= true">新增</el-button>
    </div>
    <div style="margin: 10px">
      <el-table :data="tableData" border style="width: 100%">
        <el-table-column prop="id" label="编号" width="220"></el-table-column>
        <el-table-column prop="dnum" label="宿舍号" width="270"></el-table-column>
        <el-table-column prop="dbname" label="所属公寓楼" width="358"></el-table-column>
        <el-table-column align="left" label="操作" width="160">
          <template #default="scope">
            <el-button size="mini" type="primary" @click="handleEdit(scope.row)">修改</el-button>
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

          <el-form-item label="宿舍名">
            <el-input v-model="from.dnum"></el-input>
          </el-form-item>

          <el-form-item label="所属楼">
            <el-input v-model="from.dbname"></el-input>
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
  name: "Dormitory",
  data() {
    return {
      dialogVisible: false,
      dname: '',
      tableData: [],
      from: {
        id: '',
        dnum: '',
        dbname: ''
      }
    }
  },
  created() {
    this.local();
  },
  methods: {
    local() {
      request.get("/api/Dormitory/searchAll").then(res => {
        if (res.code === '0') {
          // console.log(res.data)
          this.tableData = res.data
        }
      })
    },
    searchByName() {
      console.log(this.dname)
      request.get("/api/Dormitory/searchByName", {
        params: {
          dname: this.dname
        }
      }).then(res => {
        console.log(res.data)
        this.tableData = res.data;
        // this.local();
      })
    },
    save() {
      // let that= this;
      console.log("hahha",this.from)
      if (this.from.id) {
        // console.log("更新")
        request.put("/api/Dormitory/updateDormitory", this.from).then(res => {
          if (res.code === "0") {
            this.$message({
              type: "success",
              message: "更新成功"
            })
            this.local();
            this.from=""
          } else {
            this.$message({
              type: "error",
              message: res.msg
            })
          }
        })
      } else { // 增加
        request.post("/api/Dormitory/addDormitory", this.from).then(res => {
          if (res.code === "0") {
            this.$message({
              type: "success",
              message: "添加成功"
            })
            this.local();
          } else {
            this.$message({
              type: "error",
              message: res.msg
            })
          }
        })
      }
    },


    handleEdit(row) {
      let dor = JSON.parse(JSON.stringify(row))
      this.from = dor
      console.log(this.from)
      this.dialogVisible = true;
    },

    handleDelete(row) {
      console.log(row)
      request.delete("/api/Dormitory/deleteDormitory/" + row.id).then(res => {
        if (res.code === "0") {
          this.$message({
            type: "success",
            message: "删除成功"
          })
          this.local();
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

</style>
