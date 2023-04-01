package namvt.dev.php_project.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import namvt.dev.php_project.databinding.ItemNewsBinding
import namvt.dev.php_project.models.CommonData
import namvt.dev.php_project.models.categories.Category
import namvt.dev.php_project.models.news.News
import namvt.dev.php_project.models.users.User


class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    var listNews = mutableListOf<News>()
    var listCate = mutableListOf<Category>()
    var mulUsers = mutableListOf<User>()
    var category0 = Category("", 0, "")
    var user0 = User("", "", "", "", 0)
    lateinit var binding: ItemNewsBinding
    lateinit var onClickItemInRecyclerView: OnClickItemInRecyclerView
    lateinit var news: News


    class NewsViewHolder(
        val itemNewsBinding: ItemNewsBinding,
        onClickItemInRecyclerView: OnClickItemInRecyclerView
    ) : RecyclerView.ViewHolder(itemNewsBinding.root) {
        init {

            itemNewsBinding.root.apply {
                setOnClickListener {
                    onClickItemInRecyclerView.onItemClick(
                        absoluteAdapterPosition,
                        itemNewsBinding.root
                    )
                }
            }

        }

        fun bind(
            news: News,
            user: User,
            category: Category
        ) {
            itemNewsBinding.news = news
            itemNewsBinding.user = user
            itemNewsBinding.category = category
            itemNewsBinding.executePendingBindings()
        }
    }

    //    fun setAdapter(listNews: MutableList<News>, category: Category, user: User) {
//        this.listNews = listNews
//        this.category0 = category
//        this.user0 = user
//        Log.d("setAdapter", "setAdapter Category ${this.category0}")
//        Log.d("setAdapter", "setAdapter User ${this.user0}")
//        notifyDataSetChanged()
//    }
//    fun setAdapter(listNews: MutableList<News>) {
//        this.listNews = listNews
//        notifyDataSetChanged()
//    }
    fun setAdapter(
        listNews: MutableList<News>,
        listCate: MutableList<Category>,
        mulUsers: MutableList<User>
    ) {
        this.listNews = listNews
        this.listCate = listCate
        this.mulUsers = mulUsers
        Log.d("setAdapter", "setAdapter Category ${listCate.size}")
        Log.d("setAdapter", "setAdapter mulUsers ${mulUsers[0].imageUrl}")
        notifyDataSetChanged()
    }

    fun setCategory(cId: Int): Category {

        return category0
    }

    fun setUser(userId: Int): User {
        Log.d("setCategory", "userId ${userId}")
        return user0
    }

    fun getNews(position: Int): News {
        var news = listNews[position]
        return news
    }

    fun getCategory(position:Int): Category {
        val news = listNews[position]
        listCate.forEach {
            if (news.categoryId == it.cId) {
                this.category0 = it
                return category0

            }
        }
        return category0

    }

    fun getUser(position: Int): User {
        val news = listNews[position]
        mulUsers.forEach {
            if (news.userId == it.userId) {
                this.user0 = it
                return user0
            }
        }
        return user0
    }

    fun setOnClickItem(onClickItemInRecyclerView: OnClickItemInRecyclerView) {
        this.onClickItemInRecyclerView = onClickItemInRecyclerView
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(
            binding,
            onClickItemInRecyclerView = onClickItemInRecyclerView
        )
    }


    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = listNews[position]
        listCate.forEach {
            if (news.categoryId == it.cId) {
                this.category0 = it
                Log.d("setAdapter", "check is category is true  ")

            }
        }
        mulUsers.forEach {
            if (news.userId == it.userId) {
                this.user0 = it
                Log.d("setAdapter", "check is user is true  ")
            }
        }

        holder.bind(
            news,
            user0,
            category0
        )

    }

    override fun getItemCount(): Int {
        return listNews.size
    }

    interface OnClickItemInRecyclerView {
        fun onItemClick(position: Int, view: View)


    }
}