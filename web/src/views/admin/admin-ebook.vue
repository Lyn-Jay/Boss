<template>
  <a-layout>
    <a-layout-content :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }">
      <p>
        <a-button type="primary" @click="add()" size="large">新增</a-button>
      </p>
      <a-table
          :columns="columns"
          :row-key="record => record.id"
          :data-source="ebooks"
          :pagination="pagination"
          :loading="loading"
          @change="handleTableChange"
      >
        <template #cover="{ text: cover }">
          <img v-if="cover" :src="cover" alt="avatar" />
        </template>
        <template v-slot:action="{ text, record }">
          <a-space size="small">
            <a-button type="primary" @click="edit(record)">编辑</a-button>
            <a-popconfirm
                title="删除之后不可恢复,确认删除?"
                ok-text="是"
                cancel-text="否"
                @confirm="handleDelete(record.id)"
            >
              <a-button type="danger">删除</a-button>
            </a-popconfirm>
          </a-space>
        </template>
      </a-table>
    </a-layout-content>
  </a-layout>
  <a-modal
      title="wiki表单"
      v-model:visible="modalVisible"
      :confirm-loading="modalLoading"
      @ok="handleModalOk"
  >
    <a-form  :model="ebook" :label-col="{span : 6}" :wrapper-col="{ span: 14 }">
      <a-form-item label="封面">
        <a-input v-model:value="ebook.cover" />
      </a-form-item>
      <a-form-item label="名称">
        <a-input v-model:value="ebook.name" />
      </a-form-item>
      <a-form-item label="分类一">
        <a-input v-model:value="ebook.category1Id" />
      </a-form-item>
      <a-form-item label="分类二">
        <a-input v-model:value="ebook.category2Id" />
      </a-form-item>
      <a-form-item label="描述">
        <a-input v-model:value="ebook.description" type="text"/>
      </a-form-item>
    </a-form>
  </a-modal>
</template>

<script lang="ts">
  import { defineComponent, onMounted, ref } from 'vue';
  import axios from 'axios';
  import { message } from 'ant-design-vue';
  export default defineComponent({
    name: 'AdminEbook',
    setup() {
      const ebooks = ref();
      const pagination = ref({
        current : 1,
        pageSize : 10,
        total : 0
      })
      const loading = ref(false);
      const columns = [
        {
          title: '封面',
          dataIndex: 'cover',
          slots: { customRender: 'cover' }
        },
        {
          title: '名称',
          dataIndex: 'name'
        },
        {
          title: '分类一',
          key : 'category1Id',
          dataIndex: 'category1Id'
        },
        {
          title: '分类二',
          key : 'category2Id',
          dataIndex: 'category2Id'
        },
        {
          title: '文档数',
          key : 'docCont',
          dataIndex: 'docCont'
        },
        {
          title: '阅读数',
          key : 'viewCont',
          dataIndex: 'viewCont'
        },
        {
          title: '点赞数',
          key : 'voteCont',
          dataIndex: 'voteCont'
        },
        {
          title: 'Action',
          key: 'action',
          slots: { customRender: 'action' }
        }
      ];
      /**
       * 数据查询
       **/
      const handleQuery = (params: any) => {
        loading.value = true;
        axios.get("/ebook/list",{
          params :{
            page : params.page,
            size : params.size,
          }
        }).then(function (response){
          loading.value = false;
          const data = response.data;
          if (data.success){
            ebooks.value = data.content.list;
            // 重置分页按钮
            pagination.value.current = params.page;
            pagination.value.total = data.content.total;
          } else {
            message.error("[每页条数]不能超过1000")
          }

        });
      };
      /**
       * 表格点击页码时触发
       */
      const handleTableChange = (pagination: any) => {
        console.log("看看自带的分页参数都有啥：" + pagination);
        handleQuery({
          page: pagination.current,
          size: pagination.pageSize
        });
      };

      //表单
      const ebook = ref();
      const modalVisible = ref(false);

      const modalLoading = ref(false);
      const handleModalOk = () => {
        modalLoading.value = true;

        axios.post("/ebook/save",ebook.value).then(function (response){
          modalLoading.value = false;
          const data = response.data;
          if(data.success){
            modalVisible.value = false;
            handleQuery({
              page : pagination.value.current,
              size : pagination.value.pageSize
            });
          }else {
            message.error(data.message);
          }
        });
      };

      //编辑
      const edit = (record: any) => {
        modalVisible.value = true;
        ebook.value = JSON.parse(JSON.stringify(record));
      };

      //新增
      const add = (record: any) => {
        modalVisible.value = true;
        ebook.value = {};
      };

      //删除
      const handleDelete = (id:number) => {
        axios.delete("/ebook/delete/"+id).then(function (response){
          const data = response.data;
          if(data.success){
            handleQuery({
              page : pagination.value.current,
              size : pagination.value.pageSize
            });
          }
        });
      }


      onMounted(() => {
        handleQuery({
          page : 1,
          size : pagination.value.pageSize
        });
      });
      return {
        ebooks,
        pagination,
        loading,
        handleTableChange,
        columns,

        edit,
        add,
        handleDelete,

        ebook,
        modalVisible,
        modalLoading,
        handleModalOk

      }

    }
  });
</script>
