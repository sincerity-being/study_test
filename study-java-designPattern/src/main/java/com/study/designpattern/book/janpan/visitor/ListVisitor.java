package com.study.designpattern.book.janpan.visitor;

import com.study.designpattern.book.janpan.visitor.data.Directory;
import com.study.designpattern.book.janpan.visitor.data.Entry;
import com.study.designpattern.book.janpan.visitor.data.File;
import com.study.designpattern.book.janpan.visitor.data.FileTreatmentException;

import java.util.Iterator;

/**
 * @author HeYQ
 * @version 1.0
 * @date 2022-02-03 14:33
 * @describe
 */
public class ListVisitor extends Visitor{

    // 当前访问的文件夹的名字
    private String currentdir = " ";

    /**
     * 在访问文件时被调用
     * @param file
     */
    @Override
    public void visit(File file) {
        System.out.println(currentdir + "/" + file);
    }

    @Override
    public void visit(Directory directory) {
        System.out.println(currentdir + "/" + directory);
        String savedir = currentdir;
        currentdir = currentdir + "/" + directory.getName();
        try {
            Iterator<Entry> it = directory.iterator();
            while(it.hasNext()){
                Entry entry = it.next();
                entry.accept(this);
            }
            currentdir = savedir;
        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }

    }
}
