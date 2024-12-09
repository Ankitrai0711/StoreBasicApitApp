import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.resturantapp.MyData
import com.example.resturantapp.databinding.EachItemBinding

class MyAdapter(private val context: Context, private val list: List<MyData>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: EachItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = EachItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = list[position]

        holder.binding.apply {
            title.text = currentItem.title
            discription.text = currentItem.description
            Glide.with(context).load(currentItem.image).into(image)
        }
    }
}