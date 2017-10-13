package com.xlsz.xfspeech.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xlsz.xfspeech.R;
import com.xlsz.xfspeech.bean.Msg;

import java.util.ArrayList;

/**
 * Created by wuxiaotie on 2017/10/10.
 */
public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {

    private ArrayList<Msg> msgArrayList;
    private ButtonInterface buttonInterface;

    public MsgAdapter(ArrayList<Msg> msgArrayList) {
        this.msgArrayList = msgArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.recyclerview_item, null);
        return new ViewHolder(view);
    }

    /**
     *按钮点击事件需要的方法
     */
    public void buttonSetOnclick(ButtonInterface buttonInterface){
        this.buttonInterface=buttonInterface;
    }

    /**
     * 按钮点击事件对应的接口
     */
    public interface ButtonInterface{
        public void onclick( View view,int position);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Msg msg = msgArrayList.get(position);
        if (msg.getType() == Msg.SEND_MSG) {
            holder.recycler_chinese.setVisibility(View.VISIBLE);
            holder.recycler_english.setVisibility(View.GONE);
            holder.chinese_start_content.setText(msg.getStart_content());
            holder.chinese_end_content.setText(msg.getEnd_content());
            holder.chinese_tts.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(buttonInterface!=null) {
//                  接口实例化后的而对象，调用重写后的方法
                        buttonInterface.onclick(v,position);
                    }
                }
            });
        } else {
            holder.recycler_english.setVisibility(View.VISIBLE);
            holder.recycler_chinese.setVisibility(View.GONE);
            holder.english_start_content.setText(msg.getStart_content());
            holder.english_end_content.setText(msg.getEnd_content());
            holder.english_tts.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(buttonInterface!=null) {
//                  接口实例化后的而对象，调用重写后的方法
                        buttonInterface.onclick(v,position);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return msgArrayList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout recycler_english;
        private LinearLayout recycler_chinese;
        private TextView chinese_start_content;
        private TextView chinese_end_content;
        private TextView english_start_content;
        private TextView english_end_content;
        private ImageView english_tts;
        private ImageView chinese_tts;

        ViewHolder(View itemView) {
            super(itemView);
            recycler_english = (LinearLayout) itemView.findViewById(R.id.recycler_english);
            recycler_chinese = (LinearLayout) itemView.findViewById(R.id.recycler_chinese);
            chinese_start_content = (TextView) itemView.findViewById(R.id.chinese_start_content);
            chinese_end_content = (TextView) itemView.findViewById(R.id.chinese_end_content);
            english_start_content = (TextView) itemView.findViewById(R.id.english_start_content);
            english_end_content = (TextView) itemView.findViewById(R.id.english_end_content);
            english_tts = (ImageView) itemView.findViewById(R.id.english_tts);
            chinese_tts = (ImageView) itemView.findViewById(R.id.chinese_tts);
        }
    }
}
