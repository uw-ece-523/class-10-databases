package edu.uw.ee523.roomdbsample

import android.bluetooth.BluetoothDevice
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import edu.uw.ee523.roomdbsample.data.FriendDataEntity

class FriendDataListAdapter : ListAdapter<FriendDataEntity,
        FriendDataListAdapter.ItemViewHolder>(DiffCallback()){

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.friend_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val number = currentList[position]
        holder.bind(number, false)
    }


    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var deviceName: TextView? = itemView.findViewById(R.id.friend_list_item_firstName)
        var deviceAddress: TextView? = itemView.findViewById(R.id.friend_list_item_lastName)
//        var layout: LinearLayout? = itemView.findViewById(R.id.layout)
//        lateinit var address: String

        fun bind(item: FriendDataEntity, isSelected: Boolean) = with(itemView) {
            deviceName?.text  = item.firstName
            deviceAddress?.text = item.lastName
        }

//        fun getItemDetails(): ItemDetailsLookup.ItemDetails<String> =
//            object : ItemDetailsLookup.ItemDetails<String>() {
//                override fun getPosition(): Int = bindingAdapterPosition
//                override fun getSelectionKey(): String? = address
//            }
    }

    class DiffCallback : DiffUtil.ItemCallback<FriendDataEntity>() {
        override fun areItemsTheSame(oldItem: FriendDataEntity, newItem: FriendDataEntity): Boolean {
//            return true;
                    return oldItem.firstName == newItem.firstName && oldItem.lastName == newItem.lastName
        }

        override fun areContentsTheSame(oldItem: FriendDataEntity, newItem: FriendDataEntity): Boolean {
//            return true;
            return oldItem == newItem
        }
    }


}