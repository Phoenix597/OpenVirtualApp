package com.android.dx.dex.code.form;

import com.android.dx.dex.code.DalvInsn;
import com.android.dx.dex.code.InsnFormat;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.util.AnnotatedOutput;
import java.util.BitSet;

public final class Form23x extends InsnFormat {
  public static final InsnFormat THE_ONE = new Form23x();
  
  public int codeSize() {
    return 2;
  }
  
  public BitSet compatibleRegs(DalvInsn paramDalvInsn) {
    RegisterSpecList registerSpecList = paramDalvInsn.getRegisters();
    BitSet bitSet = new BitSet(3);
    bitSet.set(0, unsignedFitsInByte(registerSpecList.get(0).getReg()));
    bitSet.set(1, unsignedFitsInByte(registerSpecList.get(1).getReg()));
    bitSet.set(2, unsignedFitsInByte(registerSpecList.get(2).getReg()));
    return bitSet;
  }
  
  public String insnArgString(DalvInsn paramDalvInsn) {
    RegisterSpecList registerSpecList = paramDalvInsn.getRegisters();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(registerSpecList.get(0).regString());
    stringBuilder.append(", ");
    stringBuilder.append(registerSpecList.get(1).regString());
    stringBuilder.append(", ");
    stringBuilder.append(registerSpecList.get(2).regString());
    return stringBuilder.toString();
  }
  
  public String insnCommentString(DalvInsn paramDalvInsn, boolean paramBoolean) {
    return "";
  }
  
  public boolean isCompatible(DalvInsn paramDalvInsn) {
    RegisterSpecList registerSpecList = paramDalvInsn.getRegisters();
    boolean bool = paramDalvInsn instanceof com.android.dx.dex.code.SimpleInsn;
    boolean bool1 = true;
    if (!bool || registerSpecList.size() != 3 || !unsignedFitsInByte(registerSpecList.get(0).getReg()) || !unsignedFitsInByte(registerSpecList.get(1).getReg()) || !unsignedFitsInByte(registerSpecList.get(2).getReg()))
      bool1 = false; 
    return bool1;
  }
  
  public void writeTo(AnnotatedOutput paramAnnotatedOutput, DalvInsn paramDalvInsn) {
    RegisterSpecList registerSpecList = paramDalvInsn.getRegisters();
    write(paramAnnotatedOutput, opcodeUnit(paramDalvInsn, registerSpecList.get(0).getReg()), codeUnit(registerSpecList.get(1).getReg(), registerSpecList.get(2).getReg()));
  }
}


/* Location:              F:\何章易\项目文件夹\项目24\va\classes_merge.jar!\com\android\dx\dex\code\form\Form23x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */