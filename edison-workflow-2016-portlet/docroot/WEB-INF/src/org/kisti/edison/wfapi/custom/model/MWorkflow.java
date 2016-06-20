package org.kisti.edison.wfapi.custom.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.map.annotate.JsonRootName;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@SuppressWarnings("rawtypes")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"uuid", "title", "userId", "accessToken", "status", "createdTime",
    "startTime", "endTime", "simulationCount", "simulations"})
@XmlRootElement(name = "workflow")
@JsonRootName(value = "workflow")
@JsonSerialize(include = Inclusion.NON_EMPTY)
public class MWorkflow{

  private String uuid;
  private String title;
  private String userId;
  private String accessToken;
  private String status;
  private String createdTime;
  private String startTime;
  private String endTime;
  private Integer simulationCount;
  private String contentType;
  private String body;
  private List<Simulations.Simulation> simulations = new LinkedList<Simulations.Simulation>();
  public MWorkflow(){
  }
  public void setUuid(String uuid){
    this.uuid = uuid;
  }

  public void setTitle(String title){
    this.title = title;
  }

  public void setUserId(String userId){
    this.userId = userId;
  }

  public void setAccessToken(String accessToken){
    this.accessToken = accessToken;
  }

  public void setStatus(String status){
    this.status = status;
  }

  public void setCreatedTime(String createdTime){
    this.createdTime = createdTime;
  }

  public void setStartTime(String startTime){
    this.startTime = startTime;
  }

  public void setEndTime(String endTime){
    this.endTime = endTime;
  }

  public void setSimulationCount(Integer simulationCount){
    this.simulationCount = simulationCount;
  }

  public void setSimulations(List<Simulations.Simulation> simulations){
    this.simulations = simulations;
  }

  public String getContentType(){
    return contentType;
  }

  public void setContentType(String contentType){
    this.contentType = contentType;
  }

  public String getBody(){
    return body;
  }

  public void setBody(String body){
    this.body = body;
  }

  @Override
  public String toString(){
    return "Workflow [uuid=" + uuid + ", title=" + title + ", userId=" + userId + ", accessToken="
        + accessToken + ", status=" + status + ", createdTime=" + createdTime + ", startTime="
        + startTime + ", endTime=" + endTime + ", simulationCount=" + simulationCount
        + ", simulations=" + simulations + "]";
  }

  public MWorkflow(String uuid, String title, String userId, String accessToken, String status,
      String createdTime, String startTime, String endTime, Integer simulationCount,
      List<Simulations.Simulation> simulations){
    this.uuid = uuid;
    this.title = title;
    this.userId = userId;
    this.accessToken = accessToken;
    this.status = status;
    this.createdTime = createdTime;
    this.startTime = startTime;
    this.endTime = endTime;
    this.simulationCount = simulationCount;
    this.simulations = simulations;
    this.contentType = "json"; // or xml
    this.body = "";
  }

  public String getEndTime(){
    return endTime;
  }

  public String getUuid(){
    return uuid;
  }

  public String getTitle(){
    return title;
  }

  public String getUserId(){
    return userId;
  }

  public String getAccessToken(){
    return accessToken;
  }

  public String getStatus(){
    return status;
  }

  public String getCreatedTime(){
    return createdTime;
  }

  public String getStartTime(){
    return startTime;
  }

  public Integer getSimulationCount(){
    return simulationCount;
  }

  public List<Simulations.Simulation> getSimulations(){
    return simulations;
  }

  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(name = "", propOrder = {"simulation"})
  @JsonSerialize(include = Inclusion.NON_EMPTY)
  public static class Simulations{

    private List<MWorkflow.Simulations.Simulation> simulation;

    @Override
    public String toString(){
      StringBuilder sb = new StringBuilder();
      for(Iterator iterator = simulation.iterator(); iterator.hasNext();){
        Simulation tmp_simulation = (Simulation) iterator.next();
        sb.append(tmp_simulation.toString());
      }
      return "Simulations [simulation=" + sb.toString() + "]";
    }
    
    public Simulations(){
    }

    public void setSimulation(List<MWorkflow.Simulations.Simulation> simulation){
      this.simulation = simulation;
    }

    public Simulations(List<Simulation> simulation){
      this.simulation = simulation;
    }

    public List<MWorkflow.Simulations.Simulation> getSimulation(){
      if(simulation == null){
        simulation = new ArrayList<MWorkflow.Simulations.Simulation>();
      }
      return simulation;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "",
        propOrder = {"uuid", "clientId", "ibUuid", "title", "solverId", "description",
            "parentNodes", "childNodes", "status", "createdTime", "startTime", "endTime",
            "jobCount", "jobs"})
    @JsonSerialize(include = Inclusion.NON_EMPTY)
    public static class Simulation{

      private String uuid;
      private MWorkflow workflow;
      private String clientId;
      private String ibUuid;
      private String title;
      private String solverId;
      private String description;
      private ParentNodes parentNodes;
      private ChildNodes childNodes;
      private String status;
      private String createdTime;
      private String startTime;
      private String endTime;
      private Integer jobCount;
      private Long last_Update;
      private List<Simulations.Simulation.Jobs.Job> jobs = new LinkedList<Simulations.Simulation.Jobs.Job>();

      public Simulation(){
      }
      
      public MWorkflow getWorkflow(){
        return workflow;
      }

      public void setWorkflow(MWorkflow workflow){
        this.workflow = workflow;
      }

      public Long getLast_Update(){
        return last_Update;
      }

      public void setLast_Update(Long last_Update){
        this.last_Update = last_Update;
      }

      public void setUuid(String uuid){
        this.uuid = uuid;
      }

      public void setClientId(String clientId){
        this.clientId = clientId;
      }

      public void setIbUuid(String ibUuid){
        this.ibUuid = ibUuid;
      }

      public void setTitle(String title){
        this.title = title;
      }

      public void setSolverId(String solverId){
        this.solverId = solverId;
      }

      public void setDescription(String description){
        this.description = description;
      }

      public void setParentNodes(ParentNodes parentNodes){
        this.parentNodes = parentNodes;
      }

      public void setChildNodes(ChildNodes childNodes){
        this.childNodes = childNodes;
      }

      public void setStatus(String status){
        this.status = status;
      }

      public void setCreatedTime(String createdTime){
        this.createdTime = createdTime;
      }

      public void setStartTime(String startTime){
        this.startTime = startTime;
      }

      public void setEndTime(String endTime){
        this.endTime = endTime;
      }

      public void setJobCount(Integer jobCount){
        this.jobCount = jobCount;
      }

      public void setJobs(List<Simulations.Simulation.Jobs.Job> jobs){
        this.jobs = jobs;
      }

      @Override
      public String toString(){
        return "Simulation [uuid=" + uuid + ", clientId=" + clientId + ", ibUuid=" + ibUuid
            + ", title=" + title + ", solverId=" + solverId + ", description=" + description
            + ", parentNodes=" + parentNodes + ", childNodes=" + childNodes + ", status=" + status
            + ", createdTime=" + createdTime + ", startTime=" + startTime + ", endTime=" + endTime
            + ", jobCount=" + jobCount + ", jobs=" + jobs + "]";
      }

      public Simulation(String uuid, String clientId, String ibUuid, String title, String solverId,
          String description, ParentNodes parentNodes, ChildNodes childNodes, String status,
          String createdTime, String startTime, String endTime, Integer jobCount,
          List<Simulations.Simulation.Jobs.Job> jobs){
        this.uuid = uuid;
        this.clientId = clientId;
        this.ibUuid = ibUuid;
        this.title = title;
        this.solverId = solverId;
        this.description = description;
        this.parentNodes = parentNodes;
        this.childNodes = childNodes;
        this.status = status;
        this.createdTime = createdTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.jobCount = jobCount;
        this.jobs = jobs;
      }

      public String getUuid(){
        return uuid;
      }

      public String getClientId(){
        return clientId;
      }

      public String getIbUuid(){
        return ibUuid;
      }

      public String getTitle(){
        return title;
      }

      public String getSolverId(){
        return solverId;
      }

      public String getDescription(){
        return description;
      }

      public ParentNodes getParentNodes(){
        return parentNodes;
      }

      public ChildNodes getChildNodes(){
        return childNodes;
      }

      public String getStatus(){
        return status;
      }

      public String getCreatedTime(){
        return createdTime;
      }

      public String getStartTime(){
        return startTime;
      }

      public String getEndTime(){
        return endTime;
      }

      public Integer getJobCount(){
        return jobCount;
      }

      public List<MWorkflow.Simulations.Simulation.Jobs.Job> getJobs(){
        return jobs;
      }

      @XmlAccessorType(XmlAccessType.FIELD)
      @XmlType(name = "", propOrder = {"parentNode"})
      @JsonSerialize(include = Inclusion.NON_EMPTY)
      public static class ParentNodes{
        private List<String> parentNode;
        public ParentNodes(){
        }
        public void setParentNode(List<String> parentNode){
          this.parentNode = parentNode;
        }
        public ParentNodes(List<String> parentNode){
          this.parentNode = parentNode;
        }
        public List<String> getParentNode(){
          if(parentNode == null){
            parentNode = new ArrayList<String>();
          }
          return parentNode;
        }
      }

      @XmlAccessorType(XmlAccessType.FIELD)
      @XmlType(name = "", propOrder = {"childNode"})
      @JsonSerialize(include = Inclusion.NON_EMPTY)
      public static class ChildNodes{
        private List<String> childNode;
        public ChildNodes(){
        }
        public ChildNodes(List<String> childNode){
          this.childNode = childNode;
        }
        public void setChildNode(List<String> childNode){
          this.childNode = childNode;
        }
        public List<String> getChildNode(){
          if(childNode == null){
            childNode = new ArrayList<String>();
          }
          return childNode;
        }
      }

      @XmlAccessorType(XmlAccessType.FIELD)
      @XmlType(name = "", propOrder = {"job"})
      @JsonSerialize(include = Inclusion.NON_EMPTY)
      public static class Jobs{

        private List<MWorkflow.Simulations.Simulation.Jobs.Job> job;

        public void setJob(List<MWorkflow.Simulations.Simulation.Jobs.Job> job){
          this.job = job;
        }

        @Override
        public String toString(){
          StringBuilder sb = new StringBuilder();
          for(Iterator iterator = job.iterator(); iterator.hasNext();){
            Job tmp_job = (Job) iterator.next();
            sb.append(tmp_job.toString());
          }
          return "Jobs [job=" + sb.toString() + "]";
        }

        public Jobs(List<Job> job){
          this.job = job;
        }

        public List<MWorkflow.Simulations.Simulation.Jobs.Job> getJob(){
          if(job == null){
            job = new ArrayList<MWorkflow.Simulations.Simulation.Jobs.Job>();
          }
          return job;
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "",
            propOrder = {"uuid", "ibUuid", "solverId", "solverName", "type", "category", "title",
                "description", "executable", "files", "attributes", "cluster", "execution",
                "status", "submittedTime", "startTime", "endTime", "dependencies", "cyberLabId",
                "classId"})
        @JsonSerialize(include = Inclusion.NON_EMPTY)
        public static class Job{

          private String uuid;
          private String ibUuid;
          private String solverId;
          private String solverName;
          private String type;
          private String category;
          private String title;
          private String description;
          private String executable;
          private MWorkflow.Simulations.Simulation.Jobs.Job.Files files;
          private MWorkflow.Simulations.Simulation.Jobs.Job.Attributes attributes;
          private MWorkflow.Simulations.Simulation.Jobs.Job.Dependencies dependencies;
          private String cluster;
          private String execution;
          private String status;
          private String submittedTime;
          private String startTime;
          private String endTime;
          private String cyberLabId;
          private String classId;
          private Long last_Update;
          public Job(){
          }
          public Long getLast_Update(){
            return last_Update;
          }

          public void setLast_Update(Long last_Update){
            this.last_Update = last_Update;
          }

          public void setUuid(String uuid){
            this.uuid = uuid;
          }

          public void setIbUuid(String ibUuid){
            this.ibUuid = ibUuid;
          }

          public void setSolverId(String solverId){
            this.solverId = solverId;
          }

          public void setSolverName(String solverName){
            this.solverName = solverName;
          }

          public void setType(String type){
            this.type = type;
          }

          public void setCategory(String category){
            this.category = category;
          }

          public void setTitle(String title){
            this.title = title;
          }

          public void setDescription(String description){
            this.description = description;
          }

          public void setExecutable(String executable){
            this.executable = executable;
          }

          public void setFiles(MWorkflow.Simulations.Simulation.Jobs.Job.Files files){
            this.files = files;
          }

          public void setAttributes(MWorkflow.Simulations.Simulation.Jobs.Job.Attributes attributes){
            this.attributes = attributes;
          }

          public void setDependencies(MWorkflow.Simulations.Simulation.Jobs.Job.Dependencies dependencies){
            this.dependencies = dependencies;
          }

          public void setCluster(String cluster){
            this.cluster = cluster;
          }

          public void setExecution(String execution){
            this.execution = execution;
          }

          public void setStatus(String status){
            this.status = status;
          }

          public void setSubmittedTime(String submittedTime){
            this.submittedTime = submittedTime;
          }

          public void setStartTime(String startTime){
            this.startTime = startTime;
          }

          public void setEndTime(String endTime){
            this.endTime = endTime;
          }

          public void setCyberLabId(String cyberLabId){
            this.cyberLabId = cyberLabId;
          }

          public void setClassId(String classId){
            this.classId = classId;
          }

          public String getUuid(){
            return uuid;
          }

          public String getIbUuid(){
            return ibUuid;
          }

          public String getSolverId(){
            return solverId;
          }

          public String getSolverName(){
            return solverName;
          }

          public String getType(){
            return type;
          }

          public String getCategory(){
            return category;
          }

          public String getTitle(){
            return title;
          }

          public String getDescription(){
            return description;
          }

          public String getExecutable(){
            return executable;
          }

          public MWorkflow.Simulations.Simulation.Jobs.Job.Files getFiles(){
            return files;
          }

          public MWorkflow.Simulations.Simulation.Jobs.Job.Attributes getAttributes(){
            if(attributes == null){
              attributes = new Attributes();
            }
            return attributes;
          }

          public String getCluster(){
            return cluster;
          }

          public String getExecution(){
            return execution;
          }

          public String getStatus(){
            return status;
          }

          public String getSubmittedTime(){
            return submittedTime;
          }

          public String getStartTime(){
            return startTime;
          }

          public String getEndTime(){
            return endTime;
          }

          public MWorkflow.Simulations.Simulation.Jobs.Job.Dependencies getDependencies(){
            if(dependencies == null){
              dependencies = new Dependencies();
            }
            return dependencies;
          }

          public String getCyberLabId(){
            return cyberLabId;
          }

          public String getClassId(){
            return classId;
          }

          @XmlAccessorType(XmlAccessType.FIELD)
          @XmlType(name = "", propOrder = {"item"})
          @JsonSerialize(include = Inclusion.NON_EMPTY)
          public static class Files{

            private List<MWorkflow.Simulations.Simulation.Jobs.Job.Files.Item> item;
            public Files(){
            }
            public void setItem(List<MWorkflow.Simulations.Simulation.Jobs.Job.Files.Item> item){
              this.item = item;
            }

            @Override
            public String toString(){
              StringBuilder sb = new StringBuilder();
              for(Iterator iterator = item.iterator(); iterator.hasNext();){
                Item tmp_item = (Item) iterator.next();
                sb.append(tmp_item.toString());
              }
              return "Files [item=" + sb.toString() + "]";
            }

            public Files(List<Item> item){
              this.item = item;
            }

            public List<MWorkflow.Simulations.Simulation.Jobs.Job.Files.Item> getItem(){
              if(item == null){
                item = new ArrayList<MWorkflow.Simulations.Simulation.Jobs.Job.Files.Item>();
              }
              return item;
            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {"key", "value", "expectedSource", "expectedValue"})
            @JsonSerialize(include = Inclusion.NON_EMPTY)
            public static class Item{

              @XmlAttribute
              private String key;
              @XmlAttribute
              private String value;
              @XmlAttribute
              private String expectedSource;
              @XmlAttribute
              private String expectedValue;
              public Item(){
              }
              public void setKey(String key){
                this.key = key;
              }

              public void setValue(String value){
                this.value = value;
              }

              public void setExpectedSource(String expectedSource){
                this.expectedSource = expectedSource;
              }

              public void setExpectedValue(String expectedValue){
                this.expectedValue = expectedValue;
              }

              @Override
              public String toString(){
                return "Item [key=" + key + ", value=" + value + ", expectedSource="
                    + expectedSource + ", expectedValue=" + expectedValue + "]";
              }

              public Item(String key, String value, String expectedSource, String expectedValue){
                this.key = key;
                this.value = value;
                this.expectedSource = expectedSource;
                this.expectedValue = expectedValue;
              }

              public String getKey(){
                return key;
              }

              public String getValue(){
                return value;
              }

              public String getExpectedSource(){
                return expectedSource;
              }

              public String getExpectedValue(){
                return expectedValue;
              }
            }
          } /* end of class Files */

          @XmlAccessorType(XmlAccessType.FIELD)
          @XmlType(name = "", propOrder = {"item"})
          @JsonSerialize(include = Inclusion.NON_EMPTY)
          public static class Attributes{

            private List<MWorkflow.Simulations.Simulation.Jobs.Job.Attributes.Item> item;

            public void setItem(List<MWorkflow.Simulations.Simulation.Jobs.Job.Attributes.Item> item){
              this.item = item;
            }

            @Override
            public String toString(){
              StringBuilder sb = new StringBuilder();
              for(Iterator iterator = item.iterator(); iterator.hasNext();){
                Item tmp_item = (Item) iterator.next();
                sb.append(tmp_item.toString());
              }
              return "Attributes [item=" + sb.toString() + "]";
            }

            public Attributes(List<Item> item){
              this.item = item;
            }

            public Attributes(){
            }

            public List<MWorkflow.Simulations.Simulation.Jobs.Job.Attributes.Item> getItem(){
              if(item == null){
                item = new ArrayList<MWorkflow.Simulations.Simulation.Jobs.Job.Attributes.Item>();
              }
              return item;
            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {"key", "value"})
            @JsonSerialize(include = Inclusion.NON_EMPTY)
            public static class Item{

              @XmlAttribute
              private String key;
              @XmlAttribute
              private String value;

              public void setKey(String key){
                this.key = key;
              }

              public void setValue(String value){
                this.value = value;
              }

              @Override
              public String toString(){
                return "Item [key=" + key + ", value=" + value + "]";
              }

              public Item(String key, String value){
                this.key = key;
                this.value = value;
              }

              public String getKey(){
                return key;
              }

              public String getValue(){
                return value;
              }
            }
          } /* end of class Attributes */

          @XmlAccessorType(XmlAccessType.FIELD)
          @XmlType(name = "", propOrder = {"item"})
          @JsonSerialize(include = Inclusion.NON_EMPTY)
          public static class Dependencies{

            private List<MWorkflow.Simulations.Simulation.Jobs.Job.Dependencies.Item> item;

            @Override
            public String toString(){
              StringBuilder sb = new StringBuilder();
              for(Iterator iterator = item.iterator(); iterator.hasNext();){
                Item tmp_item = (Item) iterator.next();
                sb.append(tmp_item.toString());
              }
              return "Dependencies [item=" + sb.toString() + "]";
            }

            public void setItem(List<MWorkflow.Simulations.Simulation.Jobs.Job.Dependencies.Item> item){
              this.item = item;
            }
            public Dependencies(){
            }
            public Dependencies(List<Item> item){
              this.item = item;
            }

            public List<MWorkflow.Simulations.Simulation.Jobs.Job.Dependencies.Item> getItem(){
              if(item  == null){
                item = new ArrayList<MWorkflow.Simulations.Simulation.Jobs.Job.Dependencies.Item>();
              }
              return item;
            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {"key", "value"})
            @JsonSerialize(include = Inclusion.NON_EMPTY)
            public static class Item{

              @XmlAttribute
              private String key;
              @XmlAttribute
              private String value;

              public void setKey(String key){
                this.key = key;
              }

              public void setValue(String value){
                this.value = value;
              }

              @Override
              public String toString(){
                return "Item [key=" + key + ", value=" + value + "]";
              }

              public Item(String key, String value){
                this.key = key;
                this.value = value;
              }

              public String getKey(){
                return key;
              }

              public String getValue(){
                return value;
              }
            }
          } /* end of class Dependencies */

        } /* end of class Job */
      }
    }
  }
}
