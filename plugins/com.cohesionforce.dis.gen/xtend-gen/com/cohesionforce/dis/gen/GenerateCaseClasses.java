/**
 * Copyright (c) 2015 CohesionForce, Inc
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     CohesionForce, Inc - initial API and implementation
 */
package com.cohesionforce.dis.gen;

import com.google.common.collect.Iterables;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess;

/**
 * The GenerateUnmarshaller class generates a method for unmarshalling
 * each Avro class from a byte stream.
 */
@SuppressWarnings("all")
public class GenerateCaseClasses {
  /**
   * Base Package to use for the DIS classes
   */
  private final String basePackage = "com.cohesionforce.dis";
  
  /**
   * Base Package to use for the Avro classes
   */
  private final String avroPrefix = (this.basePackage + ".avro.");
  
  /**
   * Generates the unmarshaller for each class in an EPackage.
   */
  public void generateMarshaller(final EPackage anEPackage, final IFileSystemAccess fsa) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*******************************************************************************");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Copyright (c) 2015 CohesionForce, Inc");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* All rights reserved. This program and the accompanying materials");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* are made available under the terms of the Eclipse Public License v1.0");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* which accompanies this distribution, and is available at");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* http://www.eclipse.org/legal/epl-v10.html");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Contributors:");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*     CohesionForce, Inc - initial API and implementation");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*******************************************************************************/");
    _builder.newLine();
    _builder.append("package com.cohesionforce.dis;");
    _builder.newLine();
    _builder.newLine();
    {
      EList<EClassifier> _eClassifiers = anEPackage.getEClassifiers();
      Iterable<EClass> _filter = Iterables.<EClass>filter(_eClassifiers, EClass.class);
      for(final EClass eclass : _filter) {
        _builder.append("case class ");
        String _name = eclass.getName();
        _builder.append(_name, "");
        _builder.append("(");
        _builder.newLineIfNotEmpty();
        {
          EList<EStructuralFeature> _eAllStructuralFeatures = eclass.getEAllStructuralFeatures();
          boolean _hasElements = false;
          for(final EStructuralFeature aFeature : _eAllStructuralFeatures) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(",", "\t");
            }
            {
              int _upperBound = aFeature.getUpperBound();
              boolean _equals = (_upperBound == 1);
              if (_equals) {
                {
                  if ((aFeature instanceof EAttribute)) {
                    {
                      EClassifier _eType = ((EAttribute)aFeature).getEType();
                      String _name_1 = _eType.getName();
                      boolean _equalsIgnoreCase = _name_1.equalsIgnoreCase("UShort");
                      if (_equalsIgnoreCase) {
                        _builder.append("\t");
                        _builder.append("var ");
                        String _name_2 = ((EAttribute)aFeature).getName();
                        _builder.append(_name_2, "\t");
                        _builder.append(": Int = 0");
                        _builder.newLineIfNotEmpty();
                      } else {
                        EClassifier _eType_1 = ((EAttribute)aFeature).getEType();
                        String _name_3 = _eType_1.getName();
                        boolean _equalsIgnoreCase_1 = _name_3.equalsIgnoreCase("EFloat");
                        if (_equalsIgnoreCase_1) {
                          _builder.append("\t");
                          _builder.append("var ");
                          String _name_4 = ((EAttribute)aFeature).getName();
                          _builder.append(_name_4, "\t");
                          _builder.append(": Float = 0");
                          _builder.newLineIfNotEmpty();
                        } else {
                          EClassifier _eType_2 = ((EAttribute)aFeature).getEType();
                          String _name_5 = _eType_2.getName();
                          boolean _equalsIgnoreCase_2 = _name_5.equalsIgnoreCase("EDouble");
                          if (_equalsIgnoreCase_2) {
                            _builder.append("\t");
                            _builder.append("var ");
                            String _name_6 = ((EAttribute)aFeature).getName();
                            _builder.append(_name_6, "\t");
                            _builder.append(": Double = 0");
                            _builder.newLineIfNotEmpty();
                          } else {
                            EClassifier _eType_3 = ((EAttribute)aFeature).getEType();
                            String _name_7 = _eType_3.getName();
                            boolean _equalsIgnoreCase_3 = _name_7.equalsIgnoreCase("UByte");
                            if (_equalsIgnoreCase_3) {
                              _builder.append("\t");
                              _builder.append("var ");
                              String _name_8 = ((EAttribute)aFeature).getName();
                              _builder.append(_name_8, "\t");
                              _builder.append(": Short = 0");
                              _builder.newLineIfNotEmpty();
                            } else {
                              EClassifier _eType_4 = ((EAttribute)aFeature).getEType();
                              String _name_9 = _eType_4.getName();
                              boolean _equalsIgnoreCase_4 = _name_9.equalsIgnoreCase("EByte");
                              if (_equalsIgnoreCase_4) {
                                _builder.append("\t");
                                _builder.append("var ");
                                String _name_10 = ((EAttribute)aFeature).getName();
                                _builder.append(_name_10, "\t");
                                _builder.append(": Byte = 0");
                                _builder.newLineIfNotEmpty();
                              } else {
                                EClassifier _eType_5 = ((EAttribute)aFeature).getEType();
                                String _name_11 = _eType_5.getName();
                                boolean _equalsIgnoreCase_5 = _name_11.equalsIgnoreCase("UShort");
                                if (_equalsIgnoreCase_5) {
                                  _builder.append("\t");
                                  _builder.append("var ");
                                  String _name_12 = ((EAttribute)aFeature).getName();
                                  _builder.append(_name_12, "\t");
                                  _builder.append(": Int = 0");
                                  _builder.newLineIfNotEmpty();
                                } else {
                                  EClassifier _eType_6 = ((EAttribute)aFeature).getEType();
                                  String _name_13 = _eType_6.getName();
                                  boolean _equalsIgnoreCase_6 = _name_13.equalsIgnoreCase("EShort");
                                  if (_equalsIgnoreCase_6) {
                                    _builder.append("\t");
                                    _builder.append("var ");
                                    String _name_14 = ((EAttribute)aFeature).getName();
                                    _builder.append(_name_14, "\t");
                                    _builder.append(": Short = 0");
                                    _builder.newLineIfNotEmpty();
                                  } else {
                                    EClassifier _eType_7 = ((EAttribute)aFeature).getEType();
                                    String _name_15 = _eType_7.getName();
                                    boolean _equalsIgnoreCase_7 = _name_15.equalsIgnoreCase("EInt");
                                    if (_equalsIgnoreCase_7) {
                                      _builder.append("\t");
                                      _builder.append("var ");
                                      String _name_16 = ((EAttribute)aFeature).getName();
                                      _builder.append(_name_16, "\t");
                                      _builder.append(": Int = 0");
                                      _builder.newLineIfNotEmpty();
                                    } else {
                                      EClassifier _eType_8 = ((EAttribute)aFeature).getEType();
                                      String _name_17 = _eType_8.getName();
                                      boolean _equalsIgnoreCase_8 = _name_17.equalsIgnoreCase("UInt");
                                      if (_equalsIgnoreCase_8) {
                                        _builder.append("\t");
                                        _builder.append("var ");
                                        String _name_18 = ((EAttribute)aFeature).getName();
                                        _builder.append(_name_18, "\t");
                                        _builder.append(": Long = 0");
                                        _builder.newLineIfNotEmpty();
                                      } else {
                                        EClassifier _eType_9 = ((EAttribute)aFeature).getEType();
                                        String _name_19 = _eType_9.getName();
                                        boolean _equalsIgnoreCase_9 = _name_19.equalsIgnoreCase("ELong");
                                        if (_equalsIgnoreCase_9) {
                                          _builder.append("\t");
                                          _builder.append("var ");
                                          String _name_20 = ((EAttribute)aFeature).getName();
                                          _builder.append(_name_20, "\t");
                                          _builder.append(": Long = 0");
                                          _builder.newLineIfNotEmpty();
                                        } else {
                                          EClassifier _eType_10 = ((EAttribute)aFeature).getEType();
                                          String _name_21 = _eType_10.getName();
                                          boolean _equalsIgnoreCase_10 = _name_21.equalsIgnoreCase("ULong");
                                          if (_equalsIgnoreCase_10) {
                                            _builder.append("\t");
                                            _builder.append("var ");
                                            String _name_22 = ((EAttribute)aFeature).getName();
                                            _builder.append(_name_22, "\t");
                                            _builder.append(": Long = 0");
                                            _builder.newLineIfNotEmpty();
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  } else {
                    _builder.append("\t");
                    _builder.append("var ");
                    String _name_23 = aFeature.getName();
                    _builder.append(_name_23, "\t");
                    _builder.append(": ");
                    EClassifier _eType_11 = aFeature.getEType();
                    String _name_24 = _eType_11.getName();
                    _builder.append(_name_24, "\t");
                    _builder.append(" = null");
                    _builder.newLineIfNotEmpty();
                  }
                }
              } else {
                {
                  if ((aFeature instanceof EAttribute)) {
                    {
                      EClassifier _eType_12 = ((EAttribute)aFeature).getEType();
                      String _name_25 = _eType_12.getName();
                      boolean _equalsIgnoreCase_11 = _name_25.equalsIgnoreCase("UShort");
                      if (_equalsIgnoreCase_11) {
                        _builder.append("\t");
                        _builder.append("var ");
                        String _name_26 = ((EAttribute)aFeature).getName();
                        _builder.append(_name_26, "\t");
                        _builder.append(": List[Int] = null");
                        _builder.newLineIfNotEmpty();
                      } else {
                        EClassifier _eType_13 = ((EAttribute)aFeature).getEType();
                        String _name_27 = _eType_13.getName();
                        boolean _equalsIgnoreCase_12 = _name_27.equalsIgnoreCase("EFloat");
                        if (_equalsIgnoreCase_12) {
                          _builder.append("\t");
                          _builder.append("var ");
                          String _name_28 = ((EAttribute)aFeature).getName();
                          _builder.append(_name_28, "\t");
                          _builder.append(": List[Float] = null");
                          _builder.newLineIfNotEmpty();
                        } else {
                          EClassifier _eType_14 = ((EAttribute)aFeature).getEType();
                          String _name_29 = _eType_14.getName();
                          boolean _equalsIgnoreCase_13 = _name_29.equalsIgnoreCase("EDouble");
                          if (_equalsIgnoreCase_13) {
                            _builder.append("\t");
                            _builder.append("var ");
                            String _name_30 = ((EAttribute)aFeature).getName();
                            _builder.append(_name_30, "\t");
                            _builder.append(": List[Double] = null");
                            _builder.newLineIfNotEmpty();
                          } else {
                            EClassifier _eType_15 = ((EAttribute)aFeature).getEType();
                            String _name_31 = _eType_15.getName();
                            boolean _equalsIgnoreCase_14 = _name_31.equalsIgnoreCase("UByte");
                            if (_equalsIgnoreCase_14) {
                              _builder.append("\t");
                              _builder.append("var ");
                              String _name_32 = ((EAttribute)aFeature).getName();
                              _builder.append(_name_32, "\t");
                              _builder.append(": List[Short] = null");
                              _builder.newLineIfNotEmpty();
                            } else {
                              EClassifier _eType_16 = ((EAttribute)aFeature).getEType();
                              String _name_33 = _eType_16.getName();
                              boolean _equalsIgnoreCase_15 = _name_33.equalsIgnoreCase("EByte");
                              if (_equalsIgnoreCase_15) {
                                _builder.append("\t");
                                _builder.append("var ");
                                String _name_34 = ((EAttribute)aFeature).getName();
                                _builder.append(_name_34, "\t");
                                _builder.append(": List[Byte] = null");
                                _builder.newLineIfNotEmpty();
                              } else {
                                EClassifier _eType_17 = ((EAttribute)aFeature).getEType();
                                String _name_35 = _eType_17.getName();
                                boolean _equalsIgnoreCase_16 = _name_35.equalsIgnoreCase("UShort");
                                if (_equalsIgnoreCase_16) {
                                  _builder.append("\t");
                                  _builder.append("var ");
                                  String _name_36 = ((EAttribute)aFeature).getName();
                                  _builder.append(_name_36, "\t");
                                  _builder.append(": List[Int] = null");
                                  _builder.newLineIfNotEmpty();
                                } else {
                                  EClassifier _eType_18 = ((EAttribute)aFeature).getEType();
                                  String _name_37 = _eType_18.getName();
                                  boolean _equalsIgnoreCase_17 = _name_37.equalsIgnoreCase("EShort");
                                  if (_equalsIgnoreCase_17) {
                                    _builder.append("\t");
                                    _builder.append("var ");
                                    String _name_38 = ((EAttribute)aFeature).getName();
                                    _builder.append(_name_38, "\t");
                                    _builder.append(": List[Short] = null");
                                    _builder.newLineIfNotEmpty();
                                  } else {
                                    EClassifier _eType_19 = ((EAttribute)aFeature).getEType();
                                    String _name_39 = _eType_19.getName();
                                    boolean _equalsIgnoreCase_18 = _name_39.equalsIgnoreCase("EInt");
                                    if (_equalsIgnoreCase_18) {
                                      _builder.append("\t");
                                      _builder.append("var ");
                                      String _name_40 = ((EAttribute)aFeature).getName();
                                      _builder.append(_name_40, "\t");
                                      _builder.append(": List[Int] = null");
                                      _builder.newLineIfNotEmpty();
                                    } else {
                                      EClassifier _eType_20 = ((EAttribute)aFeature).getEType();
                                      String _name_41 = _eType_20.getName();
                                      boolean _equalsIgnoreCase_19 = _name_41.equalsIgnoreCase("UInt");
                                      if (_equalsIgnoreCase_19) {
                                        _builder.append("\t");
                                        _builder.append("var ");
                                        String _name_42 = ((EAttribute)aFeature).getName();
                                        _builder.append(_name_42, "\t");
                                        _builder.append(": List[Long] = null");
                                        _builder.newLineIfNotEmpty();
                                      } else {
                                        EClassifier _eType_21 = ((EAttribute)aFeature).getEType();
                                        String _name_43 = _eType_21.getName();
                                        boolean _equalsIgnoreCase_20 = _name_43.equalsIgnoreCase("ELong");
                                        if (_equalsIgnoreCase_20) {
                                          _builder.append("\t");
                                          _builder.append("var ");
                                          String _name_44 = ((EAttribute)aFeature).getName();
                                          _builder.append(_name_44, "\t");
                                          _builder.append(": List[Long] = null");
                                          _builder.newLineIfNotEmpty();
                                        } else {
                                          EClassifier _eType_22 = ((EAttribute)aFeature).getEType();
                                          String _name_45 = _eType_22.getName();
                                          boolean _equalsIgnoreCase_21 = _name_45.equalsIgnoreCase("ULong");
                                          if (_equalsIgnoreCase_21) {
                                            _builder.append("\t");
                                            _builder.append("var ");
                                            String _name_46 = ((EAttribute)aFeature).getName();
                                            _builder.append(_name_46, "\t");
                                            _builder.append(": List[Long] = null");
                                            _builder.newLineIfNotEmpty();
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  } else {
                    _builder.append("\t");
                    _builder.append("var ");
                    String _name_47 = aFeature.getName();
                    _builder.append(_name_47, "\t");
                    _builder.append(": List[");
                    EClassifier _eType_23 = aFeature.getEType();
                    String _name_48 = _eType_23.getName();
                    _builder.append(_name_48, "\t");
                    _builder.append("] = null");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
          }
        }
        _builder.append(")");
        _builder.newLine();
        _builder.newLine();
      }
    }
    fsa.generateFile("src/com/cohesionforce/dis/CaseClasses.scala", _builder);
  }
}
